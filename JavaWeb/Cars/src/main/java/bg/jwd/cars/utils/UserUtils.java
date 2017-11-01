package bg.jwd.cars.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.core.context.SecurityContextHolder;

import bg.jwd.cars.security.User;

public class UserUtils
{

	private UserUtils()
	{
	}

	public static User getUser()
	{
		Object principal;

		try
		{
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (NullPointerException e)
		{
			return null;
		}

		if (principal == null || !(principal instanceof User))
		{
			return null;
		}

		return (User) principal;
	}

	public static String encodeMd5(String aPlainText)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(aPlainText.getBytes("UTF-8"), 0, aPlainText.length());
			return new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException("No encoding algorythm found", e);
		} catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException("No encoding support", e);
		}
	}
}