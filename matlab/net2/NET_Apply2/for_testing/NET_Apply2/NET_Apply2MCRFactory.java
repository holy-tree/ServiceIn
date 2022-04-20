/*
 * MATLAB Compiler: 8.1 (R2020b)
 * Date: Sun Apr 17 00:49:08 2022
 * Arguments: 
 * "-B""macro_default""-W""java:NET_Apply2,NetApply2""-T""link:lib""-d""H:\\serviceInno\\matlab\\net2\\NET_Apply2\\for_testing""class{NetApply2:H:\\serviceInno\\matlab\\net2\\NET_Apply2.m}"
 */

package NET_Apply2;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class NET_Apply2MCRFactory
{
    /** Component's uuid */
    private static final String sComponentId = "NET_Apply2_c81b43b9-2582-41b7-88e3-3c20fd2027c7";
    
    /** Component name */
    private static final String sComponentName = "NET_Apply2";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(NET_Apply2MCRFactory.class)
        );
    
    
    private NET_Apply2MCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            NET_Apply2MCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{9,9,0}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
