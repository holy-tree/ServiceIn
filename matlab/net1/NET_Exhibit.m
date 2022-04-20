function[OUTPUT] = NET_Exhibit(n)
    
    load A;
    numl=A(1:14,:);
    numl_test=A(15,:);
    x=A(16,:);
   
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
    TRUE_VALUE = A(15,:).';
    OUTPUT = OUTPUT.' ;
    subplot(2,1,1),plot(x,OUTPUT,'r-o',x,numl_test,'b--+');legend('网络输出值', '实际值');ylabel('成锭率');
    subplot(2,1,2),plot(x,error_p,'k-*');ylabel('百分比误差');
    disp(['百分比误差均值：',num2str(average_errors)])
    disp(['决定系数(R-square)：',num2str(R2)])
    disp(['实际值：',num2str(numl_test)])
    disp(['网络输出值：',num2str(OUTPUT)])
end