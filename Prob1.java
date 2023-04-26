public class Prob1 implements Comparable<Prob1>{

    String problem;

    Prob1(String p1){
        this.problem = p1;
    }
    @Override
    public int compareTo(Prob1 o) {
        if (this.problem.compareTo(o.problem) < 0){
            return -1;
        }
        else if (this.problem.compareTo(o.problem) == 0){ 
            return 0;
        }
        else return 1;

    }
    public static void main(String[] args) {
        MinMax<Prob1> minMaxProb = new MinMax<>();

        Prob1 nik = new Prob1("spends too much time in the wait room");
        Prob1 maxq = new Prob1("Doesn't turn in homework");
        Prob1 zeke = new Prob1("Doesn't go by his full name");
        Prob1 Gilb = new Prob1("acL");
        minMaxProb.add(nik);
        minMaxProb.add(Gilb);
        minMaxProb.add(zeke);
        minMaxProb.add(maxq);
        String min = minMaxProb.getMin().problem;
        String max = minMaxProb.getMax().problem;
        System.out.println("Max: "+ max +"\t min: " + min);
    }
}
