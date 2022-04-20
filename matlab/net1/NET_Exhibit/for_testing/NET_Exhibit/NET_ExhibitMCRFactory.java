/*
 * MATLAB Compiler: 8.1 (R2020b)
 * Date: Fri Apr 15 23:02:46 2022
 * Arguments: 
 * "-B""macro_default""-W""java:NET_Exhibit,NetExhibit""-T""link:lib""-d""H:\\serviceInno\\matlab\\net1\\NET_Exhibit\\for_testing""class{NetExhibit:H:\\serviceInno\\matlab\\net1\\NET_Exhibit.m}"
 */

package NET_Exhibit;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class NET_ExhibitMCRFactory
{
    /** Component's uuid */
    private static final String sComponentId = "NET_Exhibit_27cfe9a8-6a76-420b-8026-2eaeccc16906";
    
    /** Component name */
    private static final String sComponentName = "NET_Exhibit";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(NET_ExhibitMCRFactory.class)
        );
    
    
    private NET_ExhibitMCRFactory()
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
            NET_ExhibitMCRFactory.class, 
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
