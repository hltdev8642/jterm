// function findrepeat (input)
// {
 var input = "Bed and breakfast";
 input = "gcdeeffg"
var inputArr = input.toLowerCase().split("");
var counterArr = [input.length];
var result = "";
for(var i in inputArr)
{
  counterArr[i] = 0;
}
for(var i in inputArr)
{
  // console.log(inputArr[i]);
  if(counterArr.indexOf(2) > -1 )
  {
    result = inputArr[i-1];
    break;
  }
 counterArr[inputArr.indexOf(inputArr[i])]++;

}
console.log(result);
// }
