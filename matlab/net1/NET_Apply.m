function OUTPUT=NET_Apply(num)
    numl=num';
%% ����1
    load data01 net inputps outputps%����ѵ���õ���������
    inputn_test=mapminmax('apply',numl,inputps);%�����Ԥ�����ݣ���Ԥ�����ݴ�����numl��
    netoutput=sim(net,inputn_test);%������Ԥ����
    testoutput=mapminmax('reverse',netoutput,outputps);%Ԥ��������һ��
    %% ����2
    load data02 net inputps outputps%����ѵ���õ���������
    inputn_test=mapminmax('apply',numl,inputps);%�����Ԥ�����ݣ���Ԥ�����ݴ�����numl��
    netoutput=sim(net,inputn_test);%������Ԥ����
    testoutput2=mapminmax('reverse',netoutput,outputps);%Ԥ��������һ��
    %% ����3
    load data03 net inputps outputps%����ѵ���õ���������
    inputn_test=mapminmax('apply',numl,inputps);%�����Ԥ�����ݣ���Ԥ�����ݴ�����numl��
    netoutput=sim(net,inputn_test);%������Ԥ����
    testoutput3=mapminmax('reverse',netoutput,outputps);%Ԥ��������һ��
    %% ����4
    load data04 net inputps outputps%����ѵ���õ���������
    inputn_test=mapminmax('apply',numl,inputps);%�����Ԥ�����ݣ���Ԥ�����ݴ�����numl��
    netoutput=sim(net,inputn_test);%������Ԥ����
    testoutput4=mapminmax('reverse',netoutput,outputps);%Ԥ��������һ��
    %% ���Ȩ��ֵ
    OUTPUT=(testoutput+testoutput2+testoutput3+testoutput4)/4;
    OUTPUT=OUTPUT.';
end