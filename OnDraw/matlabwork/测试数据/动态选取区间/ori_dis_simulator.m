function [mean_acc,mean_senser] = ori_dis_simulator(acc_xyz,mmindex,ori_c_o,isplot,path)
ON = 1;
OFF = 0;

k = 0.55;

%遍历 [波峰波谷四分之一 -5 , 波峰] 这个区间 
for interval = 0:1:6
    index_mean = 1;
    for start = -5:1:5
        endd = start + interval;
        position_x(1,index_mean) = 0;
        position_y(1,index_mean) = 0;
        for i = 1:1:length(mmindex)
            orient(i,index_mean) = OrientWithTime(mmindex(i,2),mmindex(i,1),acc_xyz(:,1),acc_xyz(:,2),start,endd);
            angle_sin(i,index_mean) = sin(orient(i,index_mean)/180*pi);
            angle_cos(i,index_mean) = cos(orient(i,index_mean)/180*pi);

            distance(i,index_mean) = calcudistan_Weinberg(-acc_xyz(mmindex(i,2),3),-acc_xyz(mmindex(i,1),3));
            position_x(i+1,index_mean) = position_x(i,index_mean) + angle_sin(i,index_mean) * distance(i,index_mean);
            position_y(i+1,index_mean) = position_y(i,index_mean) + angle_cos(i,index_mean) * distance(i,index_mean);
        end
        
        
            figure
            plot(position_x(:,index_mean),position_y(:,index_mean));
            title(['start:',int2str(start),' end:',int2str(endd)]);
            savepicture(path,get_picture_name(interval,start,endd));
        if isplot == OFF
            close(figure(gcf)) 
        end

        mean_acc(index_mean,interval+1) = mean_oriacc(orient(:,index_mean));
        index_mean = index_mean+1;
    end
end
mean_senser = mean_oriacc(ori_c_o(:,2));

mean_senser;
mean_acc;