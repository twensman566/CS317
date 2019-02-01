// my first program in C++
#include <cstdlib>
#include <ctime>
#include <iostream>
#include <cmath>

using namespace std; 
static double count1;
double doubleRand() {
  return double(rand()) / (double(RAND_MAX) + 1.0)-.5;
}

double dartGame(int darts){
	double x[darts];
	double y[darts];
	for(int i =0; i <darts; i++){
	x[i] = doubleRand();
	y[i] = doubleRand();
	}
	double half =.5;
	double d = 0;
	double inside = 0;
	double outside = 0;
	for(int j=0; j<darts; j++){
	d = sqrt((x[j]*x[j])+(y[j]*y[j])); 	
	if(abs(d)<half){
		inside++;
	}
	else{
		outside++;
	}
	}
	double calc = 4*(inside/darts);
	count1 = calc;
	return calc;
}

double dev(double pi[],int num){
	double meanPi = 0;
	for(int j = 0;j<num;j++){
	meanPi = meanPi + pi[j];
	}
	meanPi=meanPi/num;
	double dev = 0;
	double temp = 0;
	for(int p = 0; p<num;p++){
	temp = pi[p]-meanPi;
	dev = dev + pow(temp, 2);
}
dev = dev/num;
return dev;
}

int main() {
  srand(static_cast<unsigned int>(clock()));
  //cout << "expect 5 numbers within the interval [0.0, 1.0)" << endl;
  //for (int i=0; i < 5; i++) {
   // cout << doubleRand() << "\n";
  //}
 // cout << endl;
double pis[5]; 
 pis[0]  = dartGame(100000); 
 cout << pis[0] << "\n";
 pis[1]  = dartGame(100000);
 cout << pis[1] << "\n";

 pis[2]  = dartGame(100000);
 cout << pis[2] << "\n";

 pis[3]  = dartGame(100000);
 cout << pis[3] << "\n";

 pis[4]  = dartGame(100000);
 cout << pis[4] << "\n";

cout<<"Deviation" +  dev(pis,5)<<"\n";

}
