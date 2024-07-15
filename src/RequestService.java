import contants.MessageType;
import model.Account;
import model.Log;
import model.Provider;
import model.Request;

import java.util.*;

public class RequestService {

    Queue<Log> logs;

    HttpUtil httpRequest = new HttpUtil();

    private ProviderService providerService;

    public RequestService(ProviderService providerService) {
        this.providerService = providerService;
        logs = new PriorityQueue<>(Comparator.comparing(Log::getTimestamp));
    }


    public void sendRequest(MessageType type, Request requestBody) {
        Account accessAccount = getActiveLastProvider(type);
        if(accessAccount==null) accessAccount = providerService.accounts.get(type);

        String url = providerService.getProvider(accessAccount.getProviderId()).getUrl();
        String username = accessAccount.getUsername();
        String password = accessAccount.getPassword();

        boolean success = httpRequest.sendPOSTRequest(username, password, url, requestBody.toString());
        if(success) {
            addLogs(new Log(providerService.getProvider(accessAccount.getProviderId()), requestBody.getMessage(), String.valueOf(System.currentTimeMillis())));
        }
    }


    public void addLogs(Log log) {
        this.logs.add(log);
    }

    private Account getActiveLastProvider(MessageType type) {
        while(!logs.isEmpty()) {
            Provider provider = logs.poll().getProvider();
            List<Account> accounts = provider.getAccounts();
            for(Account account : accounts) {
                if(account.getAccessTypes().contains(type)) {
                    return account;
                }
            }
        }

        return null;
    }

}
