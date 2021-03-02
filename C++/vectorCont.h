#ifndef VECTORCONT_H
#define VECTORCONT_H


#include <iostream>
#include <cstdlib>
#include "container.hpp"
#include <vector>

class VectorContainer : public Container {
public:
VectorContainer();
VectorContainer(Sort *function);
void set_sort_function(Sort* sort_function);
void add_element(Base* element);
void print();
void sort();
void swap(int i, int j);
Base* at(int i);
int size();
private:
std::vector<Base*> primary;

};
#endif
