import java.util.ArrayList;

public class InsuranceOffice {
    private String Name;
    private ArrayList<Policy> Policies;

    public InsuranceOffice(String Name) {
        this.Name = Name;
        this.Policies = new ArrayList<>();
    }
    public void addPolicy(Policy policy) {
        Policies.add(policy);
    }
    public double calculateTotalPremium(){
        double total = 0;
        for(Policy p : Policies) {
            total += p.calculateFinalPremium();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public double calculateTotalRenewalForecast(){
        double total = 0;
        for(Policy p : Policies) {
            total += p.calculateRenewalPremium();
        }
        return Math.round(total * 100.0) / 100.0;
    }
    public int countHighRiskPolicies(){
        int count = 0;
        for(Policy p : Policies) {
            if(p.getRiskLevel() >= 4){
                count++;
            }
        }
        return count;
    }
    public Policy findByNumber(String PolicyNumber){
        for(Policy p : Policies) {
            if(p.getPolicyNumber().equals(PolicyNumber)){
                return p;
            }
        }
        return null;
    }
    public void printCheaperThan(double threshold){
        System.out.println("===== Policies Cheaper Than " + threshold + "=====");
        for(Policy p : Policies) {
            if(p.calculateFinalPremium() < threshold){
                System.out.println(p.getClass() + " - " + p.calculateRenewalPremium());
            }
        }
    }
    public void printReport(){
        System.out.println("===== REPORT: " + Name + " =====");
            for (Policy p : Policies) {
                System.out.println(p.getRiskSummary());
                System.out.println("  Final premium   : " + p.calculateFinalPremium());
                System.out.println("  Renewal forecast: " + p.calculateRenewalPremium());
                System.out.println();
            }
            System.out.println("================================");
    }
}
