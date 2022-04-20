/*
 * MATLAB Compiler: 8.1 (R2020b)
 * Date: Sat Apr 16 22:43:40 2022
 * Arguments: 
 * "-B""macro_default""-W""java:NET_Apply,NetApply""-T""link:lib""-d""H:\\serviceInno\\matlab\\net1\\NET_Apply\\for_testing""class{NetApply:H:\\serviceInno\\matlab\\net1\\NET_Apply.m}"
 */

package NET_Apply;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class NET_ApplyMCRFactory
{
    /** Component's uuid */
    private static final String sComponentId = "NET_Apply_051eea86-3fbb-435e-8dbc-2fdcdec102a9";
    
    /** Component name */
    private static final String sComponentName = "NET_Apply";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(NET_ApplyMCRFactory.class)
        );
    
    
    private NET_ApplyMCRFactory()
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
            NET_ApplyMCRFactory.class, 
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
