package ar.edu.unq.dapp.c2a.model.profile;

public class BusinessProfileBuilder extends ProfileBuilder<BusinessProfile> {
    private String description;
    private String url;
    private String schedule;

    public BusinessProfileBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public BusinessProfileBuilder withUrl(String urlServ) {
        this.url = urlServ;
        return this;
    }

    public BusinessProfileBuilder withSchedule(String schedule) {
        this.schedule = schedule;
        return this;
    }

    @Override
    public BusinessProfile build() {
        BusinessProfile instance = new BusinessProfile();
        this.setValues(instance);
        return instance;
    }

    @Override
    protected void setValues(BusinessProfile instance) {
        super.setValues(instance);
        instance.setDescription(description);
        instance.setUrlServ(url);
        instance.setSchedule(schedule);
    }

}
