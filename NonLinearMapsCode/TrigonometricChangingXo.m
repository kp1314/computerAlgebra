rMin = 0;
r = rMin;
rMax = 3;
lengthOfXkList = 10000;
lengthOfLargeXkList = 32;
Xo = 6.29;
plotXkFrom = lengthOfXkList - lengthOfLargeXkList;
hold on
while r < rMax;
Xk = repmat([0],1,lengthOfXkList);
Xk(1) = Xo;
largeXk = repmat([0],1,lengthOfLargeXkList);
i = 2;
while i <= lengthOfXkList
Xk(i) = r * sin (Xk(i - 1));
i = i + 1;
if i >= plotXkFrom
largeXk(i - plotXkFrom + 1) = r * sin (Xk(i - 1));
end
end
plot(r, largeXk, '.')
r = r + 0.001;
end
xlabel('r')
ylabel('Xk')
plot(3,3,'w')
hold off