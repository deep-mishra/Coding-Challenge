
/** Product of Array Except Self **/
class Solution {
	
	/**
	* Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]
	*
	**/
    public int[] productExceptSelf(int[] iptArr) {
      
	    int prdt=1; //product of elements in input array
        int zeroCount = 0; // counts numbe of zero
	    for(int i=0;i<iptArr.length;i++){ //find product
		    if(iptArr[i]!=0) {	 //if not zero
			    prdt*=iptArr[i]; 
            } else {
                zeroCount++;
            }
	    }
        
        if(zeroCount > 1) return new int[iptArr.length]; // if more than one element is zero then entire array prod will be zero
        
	    int[] newArr= new int[iptArr.length]; //array to be returned        
        
	    for(int i=0;i<iptArr.length;i++){
            if(zeroCount == 1 && iptArr[i] == 0 ) { // don't divide if this element is zero
                newArr[i]=prdt;
            } else if(zeroCount == 0) {
		        newArr[i]=prdt/iptArr[i];	//except index
            }
	    }
	    return (newArr);
    }
}