package utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.lpp.pojo.Administrators;
import com.it.lpp.service.rootService;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	private rootService rootservice;
	
	//清除缓存
	public void clearCache(){
		//找到当前登陆用户
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		//调用清除缓存方法
		super.clearCache(principals);
	}
	
	@Override
	public String getName() {
		return "MyRealm";
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		
		String administrators = (String) principalCollection.getPrimaryPrincipal();
	
	
		List<String> perm = new ArrayList<String>();
		if(administrators.equals("sys")){

			perm.add("employee:*");
		}
		if(administrators.equals("root")){
			perm.add("employee:list");
		}else{
			perm.add("employee:list");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(perm);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 获取用户名称
		String username = (String) token.getPrincipal();
		Administrators administrators = new Administrators();
		administrators.setRootname(username);
		Administrators user = rootservice.selectRoot(administrators);
		if (null==user) {
			// 用户名不存在抛出异常
		    return null;
		}
		return new SimpleAuthenticationInfo(username, user.getPassword(),ByteSource.Util.bytes("lpp"), getName());
	}

}
