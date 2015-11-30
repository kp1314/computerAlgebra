rMin = 2.9;
r = rMin;
rMax = 3.57;
lengthOfXkList = 10000;
lengthOfLargeXkList = 100; %May need to increase this with more period doubles
Xo = 0.1;
lambda = 2;
plotXkFrom = lengthOfXkList - lengthOfLargeXkList;
hold on
plot(0, 0, 'w')
plot(0, 1, 'w')
plot(4, 0, 'w')
plot(4, 1, 'w') %To make graph go from 1 to 3
while lambda < lengthOfXkList
while r < rMax;
Xk = repmat([0],1,lengthOfXkList);
Xk(1) = Xo;
largeXk = repmat([0],1,lengthOfLargeXkList);
toPlot = repmat([0],1,lengthOfLargeXkList);
i = 2;
while i <= lengthOfXkList
Xk(i) = r * Xk(i - 1) .* (1 - Xk(i - 1));
i = i + 1;
if i >= plotXkFrom
largeXk(i - plotXkFrom + 1) = r * Xk(i - 1) .* (1 - Xk(i - 1));
end
end
j = 1;
k = lambda + 1;
while k <= lengthOfLargeXkList
    if abs(largeXk(j) - largeXk(k)) > 0.00000001 && abs(largeXk(j) - largeXk(k))< 0.001 %Tweak these to only get single r values (0.01 gives first two r values)
        toPlot(j) = largeXk(j);
        toPlot(k) = largeXk(k);
    end
    j = j + lambda;
    k = k + lambda;
end
toPlot = toPlot(toPlot ~= 0);
if not(isempty(toPlot))
    plot(r, toPlot, '*')
end
r = r + 0.001;
end
xlabel('r')
ylabel('Xk')
lambda = 2 * lambda;
r = rMin;
end
hold off