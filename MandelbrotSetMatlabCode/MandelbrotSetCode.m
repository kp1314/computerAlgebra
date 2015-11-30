%Testing with the Mandelbrot Set

x = -2.1: 0.005: 2.1; % this is the range of x values used
y = x'; % y is the same range as x, however x is a row vector and y is a column
n = length(x); % this is the size of the range
e = ones(n,1); % an identity matrix is made with one row
c = x(e,:) + 1i*y(:,e); % c has all of the permutations of x values with y values in a meshgrid
SetOfC = zeros(n,n); % this will hold the values of z for each different c value
iterationCounter = zeros(n,n); % this will hold all of the different number of iterations for different c values.
depth = 720; % number of iterations

% performs the iterative process for each c value.
for k = 1:depth
  SetOfC = SetOfC.^(2) + c; % iterative process
  depth = depth - log2(log2(abs(SetOfC))); % a fractionaly amount of log2(log2(abs(z))) was removed from the iteration count to make the colours smoother
  iterationCounter(abs(SetOfC) < 2) = k + 2; % checks if z has escaped and then sets iteration counter to k + 2 (plus 2 to smoothen colours)
end


disp(iterationCounter);  % displays the values in iteration counter
image(iterationCounter); % Maps the values in the iteration counter gird to specific colours. 
axis image; % gives the image an axis

%print -depsc fileNameHere
