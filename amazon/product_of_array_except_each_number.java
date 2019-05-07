class Solution{

    public List<Integer> getProductSpaceOptimized(int[] arr){

        int n = arr.length; 
        int[] products = new int[n];

        for(int i=0; i<n; i++){
            products[i] = 1;
        }

        int left = 1;
        for( int i=0; i<n; i++){
            products[i] = products[i] * left; // products excluding i to left
            left *= arr[i];
        }

        int right = 1;
        for(int i=n-1; i>=0; i--){
            products[i] = products[i] * right; // also products excluding i to right
            right *= arr[i];
        }

        return new Arrays.asList(products);
    }


    public List<Integer> getProduct(int[] arr){

        int n = arr.length;
        int[] left = new int[n]; // to hold product till i, excluding i 
        int[] right = new int[n]; // to hold product till i, excluding i 
        List<Integer> products = new LinkedList<>();

        left[0] = 1;
        for( int i=1; i<n; i++){
            left[i] = left[i-1] * arr[i-1]; // products excluding i, therefore arr[i-1]
        }

        right[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            right[i] = arr[i+1] * right[i+1]; // products excluding i, therefore arr[i+1]
        }

        for( int i=0; i<n; i++){
            products.add(left[i]*right[i]);
        }

        return products;
    }
}