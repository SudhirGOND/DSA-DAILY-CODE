

public class SingleNumberThree {

    public int[] singleNumber(int[] arr) {

        int xor = 0;
        ///  xor of the all number
        for (int ele : arr) xor ^= ele; ////2 elemetn ka xor hoga jpo alaga hain

        int bitmask = (xor & (xor - 1)) ^ xor; ////  right mostt bit mask of xor
        int  b1  =  0 ;
        int b2   =  0 ;
        for(int ele  :  arr){
            if((ele & bitmask) != 0) b1 ^=ele; ///  yaddi 0 aye to esmei vrna niche

            else b2^= ele;
        }

        int[] ans  =  new int[2]; // / the answer array
        return ans;
    }
}
