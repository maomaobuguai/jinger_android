package com.OnDraw;
public class PeakFinder{
	
	float fArray3[] = new float[100];
	int iLastIndex3 = -1;
	int iIsHundred3 = 0;
	
	//���������ȶ�λ80����֤���ٿ����������������岨��
	int bufflength3 = 80;

	//����ֵ��Сֵ��־
	float isPeak = 0;
	//����ֵ�Ǳ�
	float MPeak = 0;
	//��Сֵ�Ǳ�
	float LPeak = 0;
	//����ֵ
	float MPeakIndex = 0;
	//��Сֵ
	float LPeakIndex = 0;
	
	//�󼫴�ֵ��Сֵ����Ǳ�
	public void FindPeak(float fValue){
		isPeak = 0;
		
		iLastIndex3 = (++iLastIndex3)%bufflength3 ;
		fArray3[iLastIndex3] = fValue;
		// ����û�д���ʱ�����  
		if(iIsHundred3 == 0){
			if(iLastIndex3 == bufflength3 -1){
				iIsHundred3 = 1;
			}
			//����ǵ�һ����������
			if(iLastIndex3 == 1||iLastIndex3 == 0)
			{
			    return ;
			}
			//���ǵ�һ�����ٴ���
			else
			{
					//�ж��������Ƿ񹹳ɼ���ֵ�������ڶ��������ǲ���һ������ֵ��
		  		if(fArray3[iLastIndex3 - 1] > fArray3[iLastIndex3] && 
		  		   fArray3[iLastIndex3 - 1] > fArray3[iLastIndex3 - 2])
		  	    {
		  				isPeak = 1;
		  				MPeakIndex = iLastIndex3 - 1;
		  				MPeak = fArray3[iLastIndex3 - 1];
	  				
		  		}
		  		//�ж��������Ƿ񹹳ɼ�Сֵ�������ڶ��������ǲ���һ����Сֵ��
		  		if(fArray3[iLastIndex3 - 1]<fArray3[iLastIndex3] 
		  		    && fArray3[iLastIndex3 - 1]<fArray3[iLastIndex3 - 2]){
		  				isPeak = 2;
		  				LPeakIndex = iLastIndex3 - 1;
		  				LPeak = fArray3[iLastIndex3 - 1];
		  		}
			}	
		}
		
	  //�������������������ݻḲ����������� /
		else
		{
			//�ж��������Ƿ񹹳ɼ���ֵ�������ڶ��������ǲ���һ������ֵ��
			if(fArray3[(iLastIndex3 + bufflength3 - 1) % bufflength3] > fArray3[iLastIndex3] && 
			   fArray3[(iLastIndex3 + bufflength3 - 1) % bufflength3] > fArray3[(iLastIndex3 + bufflength3 - 2) % bufflength3])
			{
  				
				isPeak = 1;
  				MPeakIndex = (iLastIndex3 + bufflength3 - 1) % bufflength3;
  				MPeak = fArray3[(iLastIndex3 + bufflength3 - 1) % bufflength3];
			}
  		//�ж��������Ƿ񹹳ɼ�Сֵ�������ڶ��������ǲ���һ����Сֵ��
			if(fArray3[(iLastIndex3 + bufflength3 - 1) % bufflength3] < fArray3[iLastIndex3] && 
			   fArray3[(iLastIndex3 + bufflength3 - 1) % bufflength3] < fArray3[(iLastIndex3 + bufflength3 - 2) % bufflength3])
			{
				
				isPeak = 2;
  				LPeakIndex = (iLastIndex3 + bufflength3 - 1) % bufflength3;
  				LPeak = fArray3[(iLastIndex3 + bufflength3 - 1) % bufflength3];
			}
		}
		//saveToSDcard(fArray3[(int) MPeakIndex],MPeakIndex,fArray3[(int) LPeakIndex],LPeakIndex);
		return;
	}
}