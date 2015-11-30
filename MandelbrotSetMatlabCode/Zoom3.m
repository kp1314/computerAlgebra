%Testing with the Mandelbrot Set

x = -0.58: 0.000005: -0.54; % This is the range of x values used
y = x'; % Y is the same range as x, however x is a row vector and y is a column
n = length(x); % This is the size of the range
e = ones(n,1); % An identity matrix is made with one row
c = x(e,:) + 1i*y(:,e); % C has all of the permutations of x values with y values in a meshgrid
SetOfC = zeros(n,n); % This will hold the values of z for each different c value
iterationCounter = zeros(n,n); % This will hold all of the different number of iterations for different c values.
depth = 720; % Number of iterations

% Performs the iterative process for each c value.
for k = 1:depth
  SetOfC = SetOfC.^(2) + c; % Iterative process
  depth = depth - log2(log2(abs(SetOfC))); % A fractionaly amount of log2(log2(abs(z))) was removed from the iteration count to make the colours smoother
  iterationCounter(abs(SetOfC) < 2) = k + 2; % Checks if z has escaped and then sets iteration counter to k + 2 (plus 2 to smoothen colours)
end

disp(iterationCounter);  % displays the values in iteration counter
image(iterationCounter); % Maps the values in the iteration counter gird to specific colours. 
axis image; % Gives the image an axis

%print -depsc fileNameHere
