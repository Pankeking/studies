import numpy as np
import matplotlib.pyplot as plt

def mandelbrot(c, max_iter):
    z = 0
    n = 0
    while abs(z) <= 2 and n < max_iter:
        z = z * z + c
        n += 1
    return n

def mandelbrot_set(xmin, xmax, ymin, ymax, width, height, max_iter):
    x = np.linspace(xmin, xmax, width)
    y = np.linspace(ymin, ymax, height)
    img = np.empty((width, height))
    for i in range(width):
        for j in range(height):
            img[i, j] = mandelbrot(x[i] + 1j * y[j], max_iter)
    return img

xmin, xmax, ymin, ymax = -2.0, 1.0, -1.5, 1.5
width, height = 3200, 3200
max_iter = 512

img = mandelbrot_set(xmin, xmax, ymin, ymax, width, height, max_iter)

plt.imshow(img.T, extent=(xmin, xmax, ymin, ymax))
plt.show()
