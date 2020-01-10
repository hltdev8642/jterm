Function → Finds and returns the first repeated char in a string.

“Momo” --> return m;
“Bed and breakfast” -> return d; (as first repeated char);


function findRepeatedChar (stringInput)
{
	var ch1 = “”;
	var ch2 = “”;
	var flag = 0;
	var strTmp = [];
	var strArr = stringInput.split(“”);
	var idxReturn = -1;
while (flag != 0)
{
	for(var i in strArr)
{
	strTmp.push(strArr[i]);
	if (strTmp.indexOf(strArr[i]) > -1)
	{

		flag++;
		idxReturn = strArr.indexOf(strTmp[i]);
	}
}
}


return strArr[idxReturn];
}
