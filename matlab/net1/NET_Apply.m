function OUTPUT=NET_Apply(num)
    numl=num';
%% 网络1
    load data01 net inputps outputps%下载训练好的网络数据
    inputn_test=mapminmax('apply',numl,inputps);%输入待预测数据，待预测数据储存在numl中
    netoutput=sim(net,inputn_test);%神经网络预测结果
    testoutput=mapminmax('reverse',netoutput,outputps);%预测结果反归一化
    %% 网络2
    load data02 net inputps outputps%下载训练好的网络数据
    inputn_test=mapminmax('apply',numl,inputps);%输入待预测数据，待预测数据储存在numl中
    netoutput=sim(net,inputn_test);%神经网络预测结果
    testoutput2=mapminmax('reverse',netoutput,outputps);%预测结果反归一化
    %% 网络3
    load data03 net inputps outputps%下载训练好的网络数据
    inputn_test=mapminmax('apply',numl,inputps);%输入待预测数据，待预测数据储存在numl中
    netoutput=sim(net,inputn_test);%神经网络预测结果
    testoutput3=mapminmax('reverse',netoutput,outputps);%预测结果反归一化
    %% 网络4
    load data04 net inputps outputps%下载训练好的网络数据
    inputn_test=mapminmax('apply',numl,inputps);%输入待预测数据，待预测数据储存在numl中
    netoutput=sim(net,inputn_test);%神经网络预测结果
    testoutput4=mapminmax('reverse',netoutput,outputps);%预测结果反归一化
    %% 求加权均值
    OUTPUT=(testoutput+testoutput2+testoutput3+testoutput4)/4;
    OUTPUT=OUTPUT.';
end