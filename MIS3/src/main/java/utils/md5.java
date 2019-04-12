package utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class md5 {
 public static void main(String[] args) {
		Md5Hash hash=new Md5Hash("19960628","lpp",3);
		System.out.println(hash);
}
}
