import java.util.Objects;
public class Policy {
    private String policyNumber;
    private String clientName;
    private int riskLevel;
    private double basePremium;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;

    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 65;

    public Policy(String policyNumber, String clientName, int riskLevel, double basePremium, double vehicleValue, boolean hasAlarm, boolean claimFreeClient) {
        this.policyNumber = policyNumber;
        this.clientName = clientName;
        this.riskLevel = riskLevel;
        this.basePremium = basePremium;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;
        createdPolicyCount++;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getClientName() {
        return clientName;
    }
    public int getRiskLevel() {
        return riskLevel;
    }
    public double getBasePremium() {
        return basePremium;
    }
    public double getVehicleValue() {
        return vehicleValue;
    }
    public boolean hasAlarm() {
        return hasAlarm;
    }
    public boolean isClaimFreeClient() {
        return claimFreeClient;
    }
    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }
    public double calculateFinalPremium(){
        double premium = basePremium + ADMINISTRATIVE_FEE;

        premium = riskLevel * 120.0;

        if(vehicleValue >= 60000){
            premium += 130;
        }
        if(hasAlarm){
            premium -= 75;
        }
        if(claimFreeClient){
            premium *= 0.90;
        }
        if(premium <= basePremium){
            premium = basePremium;
        }
        return Math.round(premium * 100) / 100.0;
    }

    public double calculateRenewalPremium(){
        double current = calculateFinalPremium();
        double renewal = current;

        if(riskLevel <= 4){
            renewal *= 1.10;
        }
        if(riskLevel >= 5 ){
            renewal *= 1.2;
        }
        if(vehicleValue >= 60000){
            renewal += 150;
        }
        if(hasAlarm){
            renewal *= 0.92;
        }
        if(claimFreeClient){
            renewal *= 0.95;
        }
        if(renewal < current * 0.9){
            renewal = current * 0.9;
        }
        if(renewal > current * 1.25){
            renewal = current * 1.25;
        }
        return Math.round(renewal * 100) / 100.0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
    public String getRiskSummary(){
        String level;
        if(riskLevel <= 2 ){
            level = "Low Risk";
        }
        else if(riskLevel == 3 ){
            level = "Medium Risk";
        }
        else{
            level = "High Risk";
        }
        return "Policy " + policyNumber + " | Client: " + clientName + " | Risk: " + level + " (level " + riskLevel + ")";
    }
    @Override
    public String toString() {
        return "Policy{" +
                "number='" + policyNumber + "'" +
                ", client='" + clientName + "'" +
                ", basePremium=" + basePremium +
                ", riskLevel=" + riskLevel +
                ", vehicleValue=" + vehicleValue +
                ", alarm=" + hasAlarm +
                ", claimFree=" + claimFreeClient +
                ", finalPremium=" + calculateFinalPremium() +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

}
