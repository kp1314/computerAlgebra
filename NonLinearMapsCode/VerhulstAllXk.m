rMin = 0;
r = rMin;
rMax = 3;
lengthOfXkList = 100;
lengthOfLargeXkList = 100;
Xo = 0.1;
plotXkFrom = lengthOfXkList - lengthOfLargeXkList;
hold on
while r < rMax;
Xk = repmat([0],1,lengthOfXkList);
Xk(1) = Xo;
largeXk = repmat([0],1,lengthOfLargeXkList);
i = 2;
while i <= lengthOfXkList
Xk(i) = Xk(i - 1) + r * Xk(i - 1) .* (1 - Xk(i - 1));
i = i + 1;
if i >= plotXkFrom
largeXk(i - plotXkFrom + 1) = Xk(i - 1) + r * Xk(i - 1) .* (1 - Xk(i - 1));
end
end
plot(r, largeXk, '.')
r = r + 0.01;
end
xlabel('r')
ylabel('Xk')
hold off