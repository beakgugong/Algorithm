class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] store = new String[n];
        String[] store1 = new String[n];
        String[] store2 = new String[n];
        StringBuffer check = new StringBuffer();
    
        for(int i=0; i<store.length; i++){
            store2[i] = "";
            store[i] = Integer.toBinaryString(arr1[i]);
            check.append(store[i]);
            if(check.length()!=n){
                for(int j=check.length(); j<n; j++){//why? j=0~j<n-check.length(), j=check.length()~j<n; 차이가 뭔가
                    check.insert(0,'0');
                }
            }
            store[i]=check.toString();
            check.setLength(0);
            
            store1[i] = Integer.toBinaryString(arr2[i]);
            check.append(store1[i]);
               if(check.length()!=n){
                for(int j=check.length(); j<n; j++){
                    check.insert(0,'0');
                }
            }
            store1[i]=check.toString();
            check.setLength(0);
        }
        for(int i=0; i<store.length; i++){
            for(int j=0; j<store[i].length(); j++){
                if(store[i].charAt(j)=='1'||store1[i].charAt(j)=='1')store2[i]+='#';
                else store2[i]+=' ';
                }
        }
        
        return store2;
    }
}