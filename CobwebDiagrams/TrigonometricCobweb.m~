hold on

Xk = -50: 0.1: 50;
plot(Xk, Xk, '--');

r = 45;
Yk = r*sin(Xk);    
plot(Xk, Yk, '-*r');

SetX = zeros(1,3);
SetY = zeros(1,3);
SetX(1,1) = 0.1;
SetY(1,1) = 0;
i = 0;
while (i < 1000)
 SetX(1,2) = SetX(1,1);
 SetY(1,2) = r*sin(SetX(1,2)); 
 SetX(1,3) = SetY(1,2);
 SetY(1,3) = SetY(1,2);
 plot(SetX, SetY,'-*g');
 SetX(1,1) = SetY(1,3);
 SetY(1,1) = SetY(1,3);
 i = i + 1;
end

hold off