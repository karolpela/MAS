package subset;

import java.util.HashSet;
import java.util.Set;

public class Businessman {
    private String name;

    private final Set<Company> companiesWhereStakeholder = new HashSet<>();
    private final Set<Company> companiesWhereChairperson = new HashSet<>();


    public Businessman(String name) {
        this.name = name;
    }

    public void makeStakeholder(Company company) {
        if (this.companiesWhereStakeholder.add(company)) {
            company.addStakeholder(this);
        }
    }

    public void makeChairperson(Company company) {
        if (this.companiesWhereStakeholder.contains(company)) {
            if (!this.companiesWhereChairperson.contains(company)) {
                this.companiesWhereChairperson.add(company);
                company.addChairperson(this);
            }
        } else {
            System.out.println(
                    "Businessman needs to be a stakeholder to become a chairperson!");
        }
    }

    public void unmakeStakeholder(Company company) {
        if (this.companiesWhereStakeholder.remove(company)) {
            this.companiesWhereChairperson.remove(company);
            company.removeStakeholder(this);
        }
    }

    public void unmakeChairperson(Company company) {
        if (this.companiesWhereChairperson.remove(company)) {
            company.removeChairperson(this);
        }
    }

    public Iterable<Company> getCompaniesWhereStakeholder() {
        return companiesWhereStakeholder;
    }

    public Iterable<Company> getCompaniesWhereChairperson() {
        return companiesWhereChairperson;
    }

    @Override
    public String toString() {
        return name;
    }
}
