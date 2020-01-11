var map1 = new Map();

var args = process.argv;
//console.log(args);
var idx = 0
var arg = args.slice("")[idx+2]
var str = arg;

console.log("Input String:",str);
var tmp = "";
var strArr = str.toLowerCase().split("");
var numArr = new Array(strArr.length);
for (var i in numArr)
{
 numArr[i] = 0;
}

for (var i in strArr)
{
  map1.set(strArr[i],0 );
}

for (var i in strArr)
{
 if(map1.get(strArr[i])>=1)
 {
    // console.log(map1.get(strArr[i]));
    tmp = strArr[i];
     break;
 }
 var value = map1.get(strArr[i]);
 map1.set(strArr[i],value+1);

}
console.log(tmp)
