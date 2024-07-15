import contants.MessageType;
import model.Account;
import model.Provider;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProviderService {


    Map<String, Provider> providers;

    Map<String, Account> accounts;

    public ProviderService() {
        this.providers = new HashMap<>();
        this.accounts = new HashMap<>();
    }



    public String addProvider(Provider provider) {
        //check if alredy exixts
        UUID id = UUID.randomUUID();
        provider.setId(id.toString());
        providers.put(id.toString(), provider);
        return "success";
    }


    public Provider getProvider(String providerId) {
        if(providers.containsKey(providerId)) {
            return providers.get(providerId);
        }
        else {
            System.out.println("Provider doesn't exist in database");
            return null;
        }
    }


    public String updateProvider(Provider provider) {
        Provider updateProvider = providers.get(provider.getId());

        updateProvider.setState(provider.isState());
        updateProvider.setUrl(provider.getUrl());
        for(Account account: provider.getAccounts()) {
            boolean exists = false;
            for(Account accountExisting: updateProvider.getAccounts()) {
                if(accountExisting.getId()==account.getId()) {
                    exists = true;
                    accountExisting.setUsername(account.getUsername());
                    accountExisting.setPassword(account.getPassword());
                }
            }
            if(!exists) {
                updateProvider.getAccounts().add(account);
            }
        }
        return "success";
    }

    public String updateState(String providerId, boolean active) {
        Provider provider = providers.get(providerId);
        provider.setState(true);
        return "success";
    }


    public Provider getProviderForCommunication(MessageType type) {
        return null;
    }
}
