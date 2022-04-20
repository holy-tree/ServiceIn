function[OUTPUT] = NET_Exhibit(n)
    
    load B;
    numl=B(1:6,:);
    numl_test=B(7,:);
    x=B(8,:);
   
    load data01 net inputps outputps
    inputn_test=mapminmax('apply',numl,inputps);
    netoutput=sim(net,inputn_test);
    testoutput=mapminmax('reverse',netoutput,outputps);

    load data02 net inputps outputps
    inputn_test=mapminmax('apply',numl,inputps);
    netoutput=sim(net,inputn_test);
    testoutput2=mapminmax('reverse',netoutput,outputps);

    load data03 net inputps outputps
    inputn_test=mapminmax('apply',numl,inputps);
    netoutput=sim(net,inputn_test);
    testoutput3=mapminmax('reverse',netoutput,outputps);
    
    load data04 net inputps outputps
    inputn_test=mapminmax('apply',numl,inputps);
    netoutput=sim(net,inputn_test);
    testoutput4=mapminmax('reverse',netoutput,outputps);
   
    OUTPUT=(testoutput+testoutput2+testoutput3+testoutput4)/4;
   
    error=OUTPUT-numl_test;
    error_p=abs(error)./numl_test;average_errors=mean(error_p);
    R2=1-sum((error).^2)/sum((numl_test-mean(numl_test)).^2);
    
    
    xx = x.';
    TRUE_VALUE = B(7,:).';
    OUTPUT = OUTPUT.' ;
end