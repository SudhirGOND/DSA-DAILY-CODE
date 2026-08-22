public class E_SubarrayProdductLessThanK {


//    Use a sliding window to maintain a product < k.
//    Expand end and multiply the new element.
//    If product >= k, move start forward until the product becomes < k.
//    For each end, there are end - start + 1 valid subarrays.
//    Add them to count.


    public int SubarrayProduct(int[] arr, int k) {

        int Product = 1;
        int count = 0;
        int start = 0, end = 0;


        while (end < arr.length) {
            Product *= arr[end];

            while (Product >= k) {
                Product /= arr[start++];
            }

            count = 1 + (end - start);

            end++;
        }

        return count;
    }
}
