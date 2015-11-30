rMin = 2.83;
r = rMin;
rMax = 2.86;
lengthOfXkList = 10000;
lengthOfLargeXkList = 32;
Xo = 0.1;
plotXkFrom = lengthOfXkList - lengthOfLargeXkList;
hold on
while r < rMax;
Xk = repmat([0],1,lengthOfXkList);
Xk(1) = Xo;
largeXk = repmat([0],1,lengthOfLargeXkList);
i = 2;
while i <= lengthOfXkList
nextElem = Xk(i - 1) + r * Xk(i - 1) .* (1 - Xk(i - 1));
Xk(i) = nextElem;
i = i + 1;
if i >= plotXkFrom && nextElem > 0.6 && nextElem < 0.74
largeXk(i - plotXkFrom + 1) = nextElem;
end
end
largeXk = largeXk(largeXk ~= 0);
plot(r, largeXk, '.')
r = r + 0.00001;
end
xlabel('r')
ylabel('Xk')
hold off