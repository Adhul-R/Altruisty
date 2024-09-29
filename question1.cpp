// You are using GCC
// You are using GCC
#include <iostream>
#include <vector>
#include <limits.h>

using namespace std;

int maxProfit(const vector<int>& prices) {
    int minPrice = INT_MAX; 
    int maxProfit = 0;      
    for (int price : prices) {
       
        if (price < minPrice) {
            minPrice = price;
        }

       
        int profit = price - minPrice;


        if (profit > maxProfit) {
            maxProfit = profit;
        }
    }

    return maxProfit;
}

int main() {
    int n;
    cin >> n;
    vector<int> prices(n);

    
    for (int i = 0; i < n; i++) {
        cin >> prices[i];
    }

    
    cout << maxProfit(prices) << endl;

    return 0;
}
