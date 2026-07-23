class Solution{
    public String removeVowels(String  s){
       StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char current=Character.toLowerCase(s.charAt(i));
            if(current!='a'&& current!='e' && current!='i'&& current!='o' && current!='u'){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    
}
