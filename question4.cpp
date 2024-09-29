#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N; // Read the number of balloons
    unordered_map<char, int> colorCount; // To store counts of each color
    vector<char> colors(N); // To store the order of colors

    // Read balloon colors
    for (int i = 0; i < N; i++) {
        cin >> colors[i]; // Each color input
        colorCount[colors[i]]++; // Count occurrences of each color
    }

    // Find the first color with an odd count
    for (char color : colors) {
        if (colorCount[color] % 2 != 0) {
            cout << color << " -> '" << color << "' colour balloon is present odd number of times in the bunch." << endl;
            return 0; // Exit after finding the first odd color
        }
    }

    // If no odd colors are found
    cout << "All are even" << endl;
    return 0;
}
