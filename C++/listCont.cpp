#include "listCont.h"

ListContainer::ListContainer() : Container() {
}

ListContainer::ListContainer(Sort* function) : Container(function) {}

void ListContainer::add_element(Base* element) {
        listCont.push_back(element);
}

void ListContainer::print() {
        for (std::list<Base*>::iterator iter = listCont.begin();
                        iter != listCont.end(); ++iter) {
                std::cout << (*iter)->stringify();
        }
}

void ListContainer::sort() {
        if (sort_function) {
                sort_function->sort(this);
        }
        else {
                throw("Null Pointer");
        }
}

void ListContainer::swap(int i, int j) {
        std::list<Base*>::iterator first = std::next(listCont.begin(), i);
        std::list<Base*>::iterator second = std::next(listCont.begin(), j);

        Base* baseAtJ = *second;
        *second = *first;
        *first = baseAtJ;
}

Base* ListContainer::at(int i) {
if (i > 0 && i < listCont.size()) {
                std::list<Base*>::iterator iter = std::next(listCont.begin(), i);
                return *iter;
        }
        else {
                throw("Out of bounds");
        }
}

int ListContainer::size() {
        return listCont.size();
}
