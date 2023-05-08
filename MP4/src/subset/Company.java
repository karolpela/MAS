package subset;

import java.util.HashSet;
import java.util.Set;

public class Company {
    private String name;

    private final Set<Businessman> stakeholders = new HashSet<>();
    private final Set<Businessman> chairpersons = new HashSet<>();

    public Company(String name) {
        this.name = name;
    }

    public void addStakeholder(Businessman businessman) {
        if (!this.stakeholders.add(businessman)) {
            businessman.makeStakeholder(this);
        }
    }

    public void addChairperson(Businessman businessman) {
        if (this.stakeholders.contains(businessman)) {
            if (!this.chairpersons.contains(businessman)) {
                this.chairpersons.add(businessman);
                businessman.makeChairperson(this);
            }
        } else {
            System.out.println("Businessman needs to be a stakeholder"
                    + "to become a chairperson!");
        }
    }

    public void removeStakeholder(Businessman businessman) {
        if (this.stakeholders.remove(businessman)) {
            this.chairpersons.remove(businessman);
            businessman.unmakeStakeholder(this);
        }
    }

    public void removeChairperson(Businessman businessman) {
        if (this.chairpersons.remove(businessman)) {
            businessman.unmakeChairperson(this);
        }
    }

    public Iterable<Businessman> getStakeholders() {
        return stakeholders;
    }

    public Iterable<Businessman> getChairpersons() {
        return chairpersons;
    }

    @Override
    public String toString() {
        return name;
    }

    // No setter because you can't change the company's taxpayer ID
}
