/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    //return nums.indexOf(target);
  var bsearch = helper(nums,target);
  while()

};

var helper = function (arr,search)
{
    var mid = arr.length/2;
   var arrA = [];
    var arrB = [];
    for(var i in arr)
        {
            if (i<=mid)
                {
                   arrA.push(arr[i]);
                }
            else
                {
                    arrB.push(arr[i])
                }
        }
  if(arrA[search] > -1)
  {return arrA;}
  else
    {return arrB;}

}