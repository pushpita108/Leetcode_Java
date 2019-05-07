class Solution{

    public void replaceWithGreatestAtRight( int[] arr ){
        int len = arr.length;
        int max = arr[len-1]; // start with last elemnt, it remains same always

        for( int i=len-2; i>=0; i--){
            max = arr[i] = Math.max( arr[i], max );
        }
    }

    public void replaceWithGreatestAtStrictRight( int[] arr ){
        int len = arr.length;
        int max = arr[len-1]; // start with last elemnt, it remains same always

        for( int i=len-2; i>=0; i--){
            int temp = arr[i]; // store it for later comparision
            arr[i] = max;
            max = Math.max( temp, max );
        }
    }

    public static void main(String args[]){

        Solution s = new Solution();

        int[] arr = { 16, 17, 4, 3, 5, 2 };

        s.replaceWithGreatestAtStrictRight(arr);

        for ( int i : arr ){
            System.out.print(i + " ");
        }

    }
}