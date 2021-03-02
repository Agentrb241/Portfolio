#ifndef __DECORATOR_H__
#define __DECORATOR_H__

#include <string>
#include "base.h"

class Decorator : public Base {
        protected:
                Base* child;
        public:
                Decorator() {};
                virtual double evaluate() = 0;
                virtual std::string stringify() = 0;


};

#endif
