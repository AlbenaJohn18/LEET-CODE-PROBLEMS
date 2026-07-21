class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones=0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                ones++;
            }
        }
        String t="1"+s+"1";
        ArrayList<Character> blocks=new ArrayList<>();
        ArrayList<Integer> lengths=new ArrayList<>();
        int i=0;
        while(i<t.length()){
            char current=t.charAt(i);
            int count=0;
            while(i<t.length() && t.charAt(i)==current){
                count++;
                i++;
            }
            blocks.add(current);
            lengths.add(count);
        }
        int maxGain=0;
        for(int j=1;j<blocks.size()-1;j++){
            if(blocks.get(j)=='1' && blocks.get(j-1)=='0' && blocks.get(j+1)=='0'){
                int gain=lengths.get(j-1)+lengths.get(j+1);
                maxGain=Math.max(maxGain,gain);
            }
        }
        return ones+maxGain;
        
    }
}
