// using Map.prototype.forEach()
// creating an empty map
var map1 = new Map();
var str = "Hello world";
var strArr = str.toLowerCase().split("");
var numArr = new Array(strArr.length);
for (var i in numArr)
{
 numArr[i] = 0;
}

for (var i in strArr)
{
  map1.set(strArr[i],0);
}


for (var i in strArr)
{

}



// for (var i in strArr)
// {
// //  map1.forEach(increment);

// }
var counter = 0;
for (let [key, value] of map1) {


  console.log(key + ' = ' + value)


}

// adding some elements to the map
// map1.set("first name", "sumit");
// map1.set("last name", "ghosh");
// map1.set("website", "geeksforgeeks")
// 	.set("friend 1", "gourav")
// 	.set("friend 2", "sourav");

function increment(values,key,map)
{
 var valtmp = map1.get(key) + 1;
 map1.set(key,valtmp);
}
// Declaring a call back function
// we are using only one parameter value
// so it will ignore other two .
function printOne(values)
{
console.log(values);
}

// It prints value of all the element
// of the set
// console.log("-----one parameter-----");
map1.forEach(printTwo);

// Declaring a call back function
// we are using two parameter value
// so it will ignore last one
function printTwo(values, key)
{
console.log(key + " " + values);
}

// As key and values are same in set
// so it will print values twice
// console.log("-----two parameter-----");
//map1.forEach(printTwo);

// Declaring a call back function
// we are using all three parameter value
function printThree(values, key, map)
{
// it will print key and value
// and the set object
console.log(key + " " + values);
console.log(map);
}

// It prints key and value of each
// element and the entire Map object
// console.log("-----three parameter-----");
//map1.forEach(printThree);
