#ifndef OP_H
#define OP_H

#include<string>
#include<iostream>
#include "base.h"
#include "iterator.hpp"

class Op : public Base {
protected:
double val;
public:
Op();
Op(double x);
double evaluate();
std::string stringify();
                Base* get_left();
                Base* get_right();
                Iterator* create_iterator();
                void accept(CountVisitor* visitor);
};
#endif
