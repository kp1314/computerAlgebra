rMin = 0.001;
r = rMin;
rMax = 3;
lengthOfXkList = 10000;
lengthOfLargeXkList = 32;
Xo = 1.4;
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
r = r + 0.001;
end
plot(0,0,'w')
plot(0,1.4,'w')
plot(3,0,'w')
plot(3,1.4,'w')
xlabel('r')
ylabel('Xk')
hold off