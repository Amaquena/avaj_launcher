Remove-Item .\practice\Main.class
javac .\practice\Main.java
if ($args.Length -eq 1) {
	java practice.Main $args;
} else {
	Write-Host "Pass a file as an arguemant.";
}