#include <iostream>
#include <vector>
#include "vectorCont.h"
#include "base.h"
#include "container.hpp"

VectorContainer::VectorContainer() {}

VectorContainer::VectorContainer(Sort *function) : Container(function) {
}

void VectorContainer::add_element(Base* element) {
primary.push_back(element);
}

void VectorContainer::print() {
for (int i = 0; i < primary.size(); ++i) {
        std::cout << primary.at(i)->stringify();
        if (i < primary.size() - 1) {
                std::cout  << " " ;
        }
}
}

void VectorContainer::sort() {
if (sort_function) {
sort_function->sort(this);
}
else {
throw ("Null Pointer");
}
}

void VectorContainer::swap(int i, int j) {
Base* x;
Base* y;
x = primary.at(i);
y = primary.at(j);
primary.at(i) = y;
primary.at(j) = x;
}

Base* VectorContainer::at(int i) {
return primary.at(i);
}
int VectorContainer::size() {
return primary.size();
}
