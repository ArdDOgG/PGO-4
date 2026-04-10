public class Main {
    public static void main(String[] args) {
        InsuranceOffice office = new InsuranceOffice("Secure Future");

        Policy p1 = new Policy("CAR-101", "Arda Gavas",    3, 900.0, 72000.0, true,  true);
        Policy p2 = new Policy("CAR-102", "Boran Ankarali",     4, 840.0, 54000.0, false, false);
        Policy p3 = new Policy("CAR-103", "Lavin Sahan Yilmaz",  2, 780.0, 46000.0, true,  false);

        office.addPolicy(p1);
        office.addPolicy(p2);
        office.addPolicy(p3);

        office.printReport();

        System.out.println("Total premium         : " + office.calculateTotalPremium());
        System.out.println("Total renewal forecast: " + office.calculateTotalRenewalForecast());
        System.out.println("High-risk policies    : " + office.countHighRiskPolicies());
        System.out.println("Total policies created: " + Policy.getCreatedPolicyCount());
        System.out.println();

        System.out.println(p1.getRiskSummary());
        System.out.println("Renewal for p1: " + p1.calculateRenewalPremium());
        System.out.println();

        Policy duplicate = new Policy("CAR-101", "Different Person", 1, 700.0, 30000.0, false, false);
        System.out.println("p1 equals duplicate (same number): " + p1.equals(duplicate));
        System.out.println();

        System.out.println("toString of p2: " + p2);
        System.out.println();

        Policy found = office.findByNumber("CAR-102");
        System.out.println("Found by number CAR-102: " + found);
        System.out.println();

        office.printCheaperThan(1400.0);

    }
}