package UsingAndAvoidingNullExplained;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;

//@NonNull: null is not a legal value
//@Nullable: null value is allowed and must be expected
//@NonNullByDefault: types in method signatures that lack a null annotation are regarded as non-null.

//Annotations @NonNull and @Nullable are supported in these locations:
//
//Method parameter
//Method return (syntactically a method annotation is used here)
//Local variables
//(more to come in the future)
//@NonNullByDefault is supported for

//Methods - to affect all types in this method's signature
//Types (classes, interfaces, enums) - to affect all methods in the type body
//Package (via a file package-info.java) - to affect all types in the package
//Note, that even the actual qualified names of these annotations are configurable, but by default the ones given above are used (from the package org.eclipse.jdt.annotation).
public class NullExample {

//	It's the caller's responsibility to never pass a null value, which is to be ensured, e.g., by an explicit null check.
//	The implementor of method capitalize enjoys the guarantee that the argument in shall not be null and thus dereferencing without a null check is OK here.
	String capitalize(@NotNull String in) {
        return in.toUpperCase();                // no null check required
    }
    void caller(String s) {
        if (s != null)
            System.out.println(capitalize(s));  // preceding null check is required
    }
    
//    Now the implementor must ensure that null is never returned.
//    Conversely the caller now enjoys the guarantee that dereferencing the method result without checking is OK.
	@NotNull
	String getString(String maybeString) {
		if (maybeString != null)
			return maybeString; // the above null check is required
		else
			return "<n/a>";
	}
    void caller1(String s) {
        System.out.println(getString(s).toUpperCase()); // no null check required
    }
    
	public static void main(String... args) {
//		String test = null;
//		if (Strings.isNullOrEmpty(test) == false) {
//			System.out.println("test");
//		} else {
//			System.out.println("test not null");
//		}
		String configuration = null;
		String sessionManager = "sessionManager";
		configuration.toCharArray();
		Preconditions.checkNotNull(configuration, "Configuration is null");
		Preconditions.checkNotNull(sessionManager, "Session manager is null");
	}

}
